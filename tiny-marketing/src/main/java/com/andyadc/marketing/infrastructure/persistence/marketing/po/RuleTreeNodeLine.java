package com.andyadc.marketing.infrastructure.persistence.marketing.po;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
public class RuleTreeNodeLine implements Serializable {

    @Serial
	private static final long serialVersionUID = 1L;

    /**
     * 自增ID
     */
	@Id
    private Long id;
    /**
     * 规则树ID
     */
    private String treeId;
    /**
     * 规则Key节点 From
     */
    private String ruleNodeFrom;
    /**
     * 规则Key节点 To
     */
    private String ruleNodeTo;
    /**
     * 限定类型；1:=;2:>;3:<;4:>=;5<=;6:enum[枚举范围];
     */
    private String ruleLimitType;
    /**
     * 限定值（到下个节点）
     */
    private String ruleLimitValue;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
