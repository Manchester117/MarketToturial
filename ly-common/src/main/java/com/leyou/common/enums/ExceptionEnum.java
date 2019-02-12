package com.leyou.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @description 定义的异常类型
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ExceptionEnum {
    BRAND_NOT_FOUND(404, "品牌不存在"),
    CATEGORY_NOT_FOUND(404, "商品分类未查到"),
    BRAND_SAVE_ERROR(500, "新增品牌失败"),
    CATEGORY_BRAND_SAVE_ERROR(500, "新增品牌分类失败"),
    UPLOAD_FILE_ERROR(500, "文件上传失败"),
    INVALID_FILE_TYPE(400, "无效的文件类型");

    private int code;
    private String msg;
}
