package com.mengan.webdemo.ctrl;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: zhanmingwei
 */

@NoArgsConstructor
@Data
public class Format {
    @JsonProperty("client_key")
    private String clientKey;
    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("ext_shop_id")
    private String extShopId;
    @JsonProperty("app_name")
    private String appName;
    @JsonProperty("open_id")
    private String openId;
    @JsonProperty("update_time")
    private Long updateTime;
    @JsonProperty("order_detail")
    private String orderDetail;
    @JsonProperty("order_type")
    private Integer orderType;
    @JsonProperty("order_status")
    private Integer orderStatus;
    @JsonProperty("payment_order_no")
    private String paymentOrderNo;
    @JsonProperty("extra")
    private String extra;
    @JsonProperty("scene")
    private String scene;
    @JsonProperty("launch_from")
    private String launchFrom;
    @JsonProperty("location")
    private String location;

    @Data
    public static class OrderDetail {
        @JsonProperty("ext_order_id")
        private String extOrderId;
        @JsonProperty("status")
        private Long status;
        @JsonProperty("shop_name")
        private String shopName;
        @JsonProperty("entry_type")
        private Long entryType;
        @JsonProperty("entry_schema")
        private String entrySchema;
        @JsonProperty("create_order_time")
        private Long createOrderTime;
        @JsonProperty("description")
        private String description;
        @JsonProperty("total_price")
        private Long totalPrice;
        @JsonProperty("pay_time")
        private Long payTime;
        @JsonProperty("ext_valid_shop_id")
        private String extValidShopId;
        @JsonProperty("valid_poi_id_str")
        private String validPoiIdStr;
        @JsonProperty("ext_goods_id")
        private String extGoodsId;
        @JsonProperty("goods_name")
        private String goodsName;
        @JsonProperty("goods_info")
        private String goodsInfo;
        @JsonProperty("goods_cover_image")
        private String goodsCoverImage;
        @JsonProperty("goods_entry_type")
        private Long goodsEntryType;
        @JsonProperty("goods_entry_schema")
        private String goodsEntrySchema;
        @JsonProperty("start_valid_time")
        private String startValidTime;
        @JsonProperty("end_valid_time")
        private String endValidTime;
        @JsonProperty("ticket_num")
        private Long ticketNum;
        @JsonProperty("ext_ticket_ids")
        private List<String> extTicketIds;
        @JsonProperty("ticket_description")
        private List<String> ticketDescription;

    }


}