package thoth.spring.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import thoth.spring.project.dao.OrderDAO;
import thoth.spring.project.dao.ProductDAO;
import thoth.spring.project.utils.ImgUploadUtil;
import thoth.spring.project.vo.BookImage;
import thoth.spring.project.vo.Order;
import thoth.spring.project.vo.Product;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("osrv")
public class OrderServiceImpl implements OrderService{

    @Autowired private OrderDAO odao;


    // 상품 등록
    @Override
    public boolean newOrder(Order o){
        //DAO에 전달
        boolean isInserted = false;
        if(odao.insertOrder(o)>0) isInserted = true;
        return isInserted;
    }

    @Override
    public Order readOneOrder(String tnum) {
        return odao.selectOneOrder(tnum);
    }


}
