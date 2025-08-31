package com.andyadc.codecraft.design.framework.tree;

/**
 * 策略路由抽象类
 *
 * @param <T>
 * @param <D>
 * @param <R>
 */
public abstract class AbstractStrategyRouter<T, D, R> implements StrategyMapper<T, D, R>, StrategyHandler<T, D, R> {

	protected StrategyHandler<T, D, R> defaultStrategyHandler = StrategyHandler.DEFAULT;

	public R router(T requestParameter, D dynamicContext) throws Exception {
		StrategyHandler<T, D, R> strategyHandler = get(requestParameter, dynamicContext);
		if (null != strategyHandler)
			return strategyHandler.apply(requestParameter, dynamicContext);
		return defaultStrategyHandler.apply(requestParameter, dynamicContext);
	}

	public StrategyHandler<T, D, R> getDefaultStrategyHandler() {
		return defaultStrategyHandler;
	}

	public void setDefaultStrategyHandler(StrategyHandler<T, D, R> defaultStrategyHandler) {
		this.defaultStrategyHandler = defaultStrategyHandler;
	}

}
