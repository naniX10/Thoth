package thoth.spring.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import thoth.spring.project.dao.ProductDAO;
import thoth.spring.project.utils.ImgUploadUtil;
import thoth.spring.project.vo.BookImage;
import thoth.spring.project.vo.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("psrv")
public class ProductServiceImpl implements ProductService{

    @Autowired private ProductDAO pdao;
    @Autowired private ImgUploadUtil imgutil;

    // 상품 조회 - n개의 게시글 출력
    @Override
    public List<Product> readProduct(String cp) {
        int snum = (Integer.parseInt(cp)-1)*10; // 10개 게시물 출력
        return pdao.selectProduct(snum);
    }
    // 상품 조회 - 전체 상품 갯수 구하기
    @Override
    public int countProduct(){
        return pdao.selectCountProduct();
    }

    // 상품 조회 - 검색(내부)
    @Override
    public List<Product> readProduct(String cp, String ftype, String fkey) {
        int snum = 10*(Integer.parseInt(cp)-1); // 10개 게시물 고정
        Map<String, Object> params = new HashMap<>();
        params.put("snum",snum);
        params.put("ftype",ftype);
        params.put("fkey",fkey);
        return pdao.findSelectProduct(params);
    }

    // 상품 조회 - 검색된 상품 수
    @Override
    public int countProduct(String ftype, String fkey) {
        Map<String,Object> params = new HashMap<>();
        params.put("ftype",ftype);
        params.put("fkey",fkey);
        return pdao.selectCountProduct(params);
    }

    // 상품 상세 조회
    @Override
    public Product readOneProduct(String tnum) {
        return pdao.selectOneProduct(tnum);
    }
    
    // 상품 등록
    @Override
    public boolean newProduct(Product p, BookImage b, MultipartFile[] img){
        
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
        if(pdao.insertProduct(p,b)>0) isInserted = true;
        //pdao.insertProduct(p,b);
        return isInserted;
    }

    // 상품 삭제
    @Override
    public Product removeProduct(String tnum) {
        Product p = pdao.selectOneProduct(tnum); // 지우고자 하는 상품 분류코드
        pdao.deleteProduct(tnum);
        return p;
    }

    // 상품 상세 조회 - 이미지
    @Override
    public BookImage readOneImage(String tnum) {
        return pdao.selectOneImage(tnum);
    }

    // 상품 삭제 - 이미지
    @Override
    public BookImage removeImage(String tnum) {
        BookImage b = pdao.selectOneImage(tnum); // 지우고자 하는 상품 분류코드
        pdao.deleteImage(tnum);
        return b;
    }

    // 상품 수정
    @Override
    public void modifyProduct(Product p) {
        pdao.updateProduct(p);
    }

    // 상품 수정 - 이미지
    @Override
    public void modifyImage(BookImage b, MultipartFile[] img) {

    }


}
