package com.lxy11.drbox.Dao;

import com.lxy11.drbox.dto.ChartDto;
import com.lxy11.drbox.po.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChartRepository extends JpaRepository<Price, Integer> {
    Price findChartInfoById(int id);
//    List<Price> findUserInfoByStatus(boolean status);

    @Query(value = "select new com.lxy11.drbox.dto.ChartDto(goodsPrice, update_at) from  Price  where goodsId = ?1 order by update_at")
    public List<ChartDto> nativeQuery(int goodsId);
}
