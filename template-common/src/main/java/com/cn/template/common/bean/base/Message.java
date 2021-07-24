package com.cn.template.common.bean.base;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class Message implements Serializable {

    /**
     * 序列化ID
     */
    private static final long serialVersionUID = -5809782578272943999L;

    /**
     * 消息头
     */
    private String head;

    /**
     * 消息体
     */
    private String body;

    /**
     * 消息尾
     */
    private String foot;

    /**
     * 附加信息
     */
    private String addition;

    public Message() {}

    public Message(String head, String body) {
        this.head = head;
        this.body = body;
    }

    public Message(String head, String body, String foot) {
        this.head = head;
        this.body = body;
        this.foot = foot;
    }

    public Message(String head, String body, String foot, String addition) {
        this.head = head;
        this.body = body;
        this.foot = foot;
        this.addition = addition;
    }
}
