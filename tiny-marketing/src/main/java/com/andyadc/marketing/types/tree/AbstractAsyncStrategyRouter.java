package com.andyadc.marketing.types.tree;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/**
 * 异步资源加载策略
 *
 * @param <P>
 * @param <C>
 * @param <R>
 */
public abstract class AbstractAsyncStrategyRouter<P, C, R> implements StrategyMapper<P, C, R>, StrategyHandler<P, C, R> {

	protected StrategyHandler<P, C, R> defaultStrategyHandler = StrategyHandler.DEFAULT;

	public R router(P requestParameter, C dynamicContext) throws Exception {
		StrategyHandler<P, C, R> strategyHandler = get(requestParameter, dynamicContext);

		if (strategyHandler != null)
			return strategyHandler.apply(requestParameter, dynamicContext);

		return defaultStrategyHandler.apply(requestParameter, dynamicContext);
	}

	@Override
	public R apply(P requestParameter, C dynamicContext) throws Exception {
		async(requestParameter, dynamicContext);
		return doApply(requestParameter, dynamicContext);
	}

	/**
	 * 异步加载数据
	 */
	protected abstract void async(P requestParameter, C dynamicContext) throws ExecutionException, InterruptedException, TimeoutException;

	/**
	 * 业务流程受理
	 */
	protected abstract R doApply(P requestParameter, C dynamicContext) throws Exception;

}
