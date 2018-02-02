package com.lxy11.drbox.Dao;

import java.util.List;
import com.lxy11.drbox.dto.GoodsDto;
import com.lxy11.drbox.po.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GoodsRepository extends JpaRepository<Goods, Integer> {

//    @Query(value = "select new com.lxy11.drbox.dto.GoodsDto(id,goodsUrl,goodsName,goodsType,userId) from Goods order by userId")
//    public List<GoodsDto> ps();

    @Query(value = "select new com.lxy11.drbox.dto.GoodsDto(id,goodsPrice,goodsType,goodsName,goodsUrl,created_at ) from  Goods  where userId = ?1 order by created_at")
    public List<GoodsDto> nq (int userId);


    }
