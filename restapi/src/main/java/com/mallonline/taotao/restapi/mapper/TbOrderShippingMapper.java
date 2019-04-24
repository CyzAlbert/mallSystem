package com.mallonline.taotao.restapi.mapper;

import com.mallonline.taotao.restapi.entity.TbOrderShipping;
import com.mallonline.taotao.restapi.entity.TbOrderShippingExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbOrderShippingMapper {
    int countByExample(TbOrderShippingExample example);

    int deleteByExample(TbOrderShippingExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(TbOrderShipping record);

    int insertSelective(TbOrderShipping record);

    List<TbOrderShipping> selectByExample(TbOrderShippingExample example);

    TbOrderShipping selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") TbOrderShipping record, @Param("example") TbOrderShippingExample example);

    int updateByExample(@Param("record") TbOrderShipping record, @Param("example") TbOrderShippingExample example);

    int updateByPrimaryKeySelective(TbOrderShipping record);

    int updateByPrimaryKey(TbOrderShipping record);
}
