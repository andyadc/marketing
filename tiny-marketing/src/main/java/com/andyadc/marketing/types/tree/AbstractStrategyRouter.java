package com.andyadc.marketing.types.tree;

/**
 * 策略路由抽象类
 *
 * @param <P>
 * @param <C>
 * @param <R>
 */
public abstract class AbstractStrategyRouter<P, C, R> implements StrategyMapper<P, C, R>, StrategyHandler<P, C, R> {

	protected StrategyHandler<P, C, R> defaultStrategyHandler = StrategyHandler.DEFAULT;

	public R router(P requestParameter, C dynamicContext) throws Exception {
		StrategyHandler<P, C, R> strategyHandler = get(requestParameter, dynamicContext);

		if (strategyHandler != null)
			return strategyHandler.apply(requestParameter, dynamicContext);

		return defaultStrategyHandler.apply(requestParameter, dynamicContext);
	}

	public StrategyHandler<P, C, R> getDefaultStrategyHandler() {
		return defaultStrategyHandler;
	}

	public void setDefaultStrategyHandler(StrategyHandler<P, C, R> defaultStrategyHandler) {
		this.defaultStrategyHandler = defaultStrategyHandler;
	}

}
