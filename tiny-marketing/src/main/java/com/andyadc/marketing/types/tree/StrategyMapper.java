package com.andyadc.marketing.types.tree;

/**
 * 策略映射器
 *
 * @param <P> 入参类型
 * @param <C> 上下文参数
 * @param <R> 返参类型
 */
public interface StrategyMapper<P, C, R> {

	/**
	 * 获取待执行策略
	 *
	 * @param requestParameter 入参
	 * @param dynamicContext   上下文
	 * @return 返参
	 * @throws Exception 异常
	 */
	StrategyHandler<P, C, R> get(P requestParameter, C dynamicContext) throws Exception;

}
