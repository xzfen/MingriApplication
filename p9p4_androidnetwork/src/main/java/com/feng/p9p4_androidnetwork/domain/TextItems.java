package com.feng.p9p4_androidnetwork.domain;

import java.util.List;

/**
 * @项目名称：MingriApplication
 * @包名：com.feng.p9p4_androidnetwork.domain
 * @作者：FENG
 * @类名：TextItem
 * @创建时间：2022/11/710:36
 * @描述：
 **/
public class TextItems {

    @com.google.gson.annotations.SerializedName("success")
    private Boolean success;
    @com.google.gson.annotations.SerializedName("code")
    private long code;
    @com.google.gson.annotations.SerializedName("message")
    private String message;
    @com.google.gson.annotations.SerializedName("data")
    private List<DataBean> data;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        @com.google.gson.annotations.SerializedName("id")
        private long id;
        @com.google.gson.annotations.SerializedName("title")
        private String title;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
