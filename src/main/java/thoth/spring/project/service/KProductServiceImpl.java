package thoth.spring.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import thoth.spring.project.dao.BaProductDAO;
import thoth.spring.project.dao.KProductDAO;
import thoth.spring.project.utils.ImgUploadUtil;
import thoth.spring.project.vo.BookImage;
import thoth.spring.project.vo.Product;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("pksrv")
public class KProductServiceImpl implements KProductService{

    @Autowired private KProductDAO pkdao;
    @Autowired private ImgUploadUtil imgutil;

    /* ch */

    @Override
    public List<Product> kreadProduct(String cp) {
        int snum = (Integer.parseInt(cp)-1)*20; // 10개 게시물 출력
        return pkdao.kselectProduct(snum);
    }

    @Override
    public int kcountProduct() {
        return pkdao.kselectCountProduct();
    }

    @Override
    public List<Product> kreadProduct(String cp, String findtype, String findkey) {
        int snum = 10*(Integer.parseInt(cp)-1); // 10개 게시물 고정
        Map<String, Object> params = new HashMap<>();
        params.put("snum",snum);
        params.put("ftype",findtype);
        params.put("fkey",findkey);
        return pkdao.kfindSelectProduct(params);
    }

    @Override
    public int kcountProduct(String findtype, String findkey) {
        Map<String,Object> params = new HashMap<>();
        params.put("ftype",findtype);
        params.put("fkey",findkey);
        return pkdao.kselectCountProduct(params);
    }

    @Override
    public boolean knewProduct(Product p, BookImage b, MultipartFile[] img) {
        // 식별코드 생성
        String uuid = imgutil.makeUUID();

        // 첨부파일이 존재할 경우
        if(imgutil.checkImageFiles(img)) {

            // 이미지명 저장을 위한 공간 생성
            List<String> imgs = new ArrayList<>();


            // imgs에 저장, 저장 실패시 '-/-'를 넘김
            for (MultipartFile f : img) {
                if (!f.getOriginalFilename().isEmpty())
                    imgs.add(imgutil.ImageUpload(f, uuid));
                else
                    imgs.add("-/-");
            }

            // DB저장을 위한 변수 선언
            String fnames = "";
            String fsizes = "";

            // 파일명, 파일크기 저장
            for (int i = 0; i < imgs.size(); ++i) {
                fnames += imgs.get(i).split("/")[0] + "/";
                fsizes += imgs.get(i).split("/")[1] + "/";
            }

            // VO에 반영
            b.setFnames(fnames);
            b.setFsizes(fsizes);
            b.setUuid(uuid);

            p.setFnames(fnames);
            p.setFsizes(fsizes);
            p.setUuid(uuid);

        }

        //DAO에 전달
        boolean isInserted = false;
        if(pkdao.kinsertProduct(p,b)>0) isInserted = true;
        //pdao.insertProduct(p,b);
        return isInserted;
    }

    @Override
    public Product kreadOneProduct(String tnum) {
        return pkdao.kselectOneProduct(tnum);
    }

    @Override
    public BookImage kreadOneImage(String tnum) {
        return pkdao.kselectOneImage(tnum);
    }

    @Override
    public Product kremoveProduct(String tnum) {
        Product p = pkdao.kselectOneProduct(tnum); // 지우고자 하는 상품 분류코드
        pkdao.kdeleteProduct(tnum);
        return p;
    }

    @Override
    public BookImage kremoveImage(String tnum) {
        BookImage b = pkdao.kselectOneImage(tnum); // 지우고자 하는 상품 분류코드
        pkdao.kdeleteImage(tnum);
        return b;
    }

    @Override
    public void kmodifyProduct(Product p) {
        pkdao.kupdateProduct(p);
    }

    @Override
    public void kmodifyImage(BookImage b, MultipartFile[] img) {
        // 수정된 첨부이미지를 지정한 위치에 저장
        // 수정된 이미지파일의 정보를 테이블에 수정

        // 첨부파일이 존재할 경우
        if(imgutil.checkImageFiles(img)) {
            List<String> imgs = new ArrayList<>();

            for(MultipartFile f : img) {
                if (!f.getOriginalFilename().isEmpty())
                    imgs.add(imgutil.ImageUpload(f, b.getUuid()));
                else
                    imgs.add("-/-");
            } // for

            // 기존 fnames, fsizes를 읽어옴
            String fn = pkdao.readFnames(b.getTnum());
            String fs = pkdao.readFsizes(b.getTnum());

            // 새로 생성된 fnames와 fsizes 값을
            // 기존의 fnames와 fsizes에 수정
            String[] ofn = fn.split("[/]");
            String[] ofs = fs.split("[/]");

            String fnames = "";
            String fsizes = "";
            for (int i = 0; i < imgs.size(); ++i) {
                fnames += imgs.get(i).split("[/]")[0] + "/";
                fsizes += imgs.get(i).split("[/]")[1] + "/";
            }

            String[] nfn = fnames.split("[/]");
            String[] nfs = fsizes.split("[/]");

            // todie = 13
            // ofn[0] = 새로운수정된 파일1명
            // ofn[2] = 새로운수정된 파일2명
            String todie[] = new String[3];  // 삭제대상  파일이름
            for(int i = 0; i < b.getTodie().length(); ++i) {
                int pos = Integer.parseInt(b.getTodie().substring(i, i+1));
                ofn[pos-1] = nfn[i];  // 변경한 파일이름 저장
                ofs[pos-1] = nfs[i];
                todie[i] = fn.split("[/]")[pos-1];  // 삭제할 파일이름 저장
            }

            // 수정된 결과 확인
            // System.out.println(String.join("/", ofn));
            fnames = String.join("/", ofn);
            fsizes = String.join("/", ofs);

            b.setFnames( fnames );
            b.setFsizes( fsizes );

            // 이미지 제거
            String fpath = "D:/nginx-1.21.0/html/";
            for (int i = 0; i < todie.length; ++i) {
                try {
                    // 파일이름 재조합을 위해 분해
                    int pos = todie[i].lastIndexOf(".");
                    String name = todie[i].substring(0, pos);   // 이미지명
                    String ext = todie[i].substring(pos + 1);  // 확장자
                    // 이미지 경로 생성
                    String one = name + b.getUuid() + "." + ext;

                    File f = new File(fpath + "book/" + one); // 이미지
                    f.delete();
                } catch (Exception ex) { }
            }

        } // if

        // 수정된 내용 및 파일정보를 테이블에 저장
        pkdao.kupdateImage(b);

    }

}
