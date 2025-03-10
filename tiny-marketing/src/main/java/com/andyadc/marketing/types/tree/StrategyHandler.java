package com.andyadc.marketing.types.tree;

/**
 * 受理策略处理
 *
 * @param <P> 入参类型
 * @param <C> 上下文参数
 * @param <R> 返参类型
 */
public interface StrategyHandler<P, C, R> {

	StrategyHandler DEFAULT = (P, C) -> null;

	R apply(P requestParameter, C dynamicContext) throws Exception;

}
