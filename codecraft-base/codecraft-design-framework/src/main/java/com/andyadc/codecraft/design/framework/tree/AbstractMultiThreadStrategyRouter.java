package com.andyadc.codecraft.design.framework.tree;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/**
 * 异步资源加载策略
 *
 * @param <T>
 * @param <D>
 * @param <R>
 */
public abstract class AbstractMultiThreadStrategyRouter<T, D, R> implements StrategyMapper<T, D, R>, StrategyHandler<T, D, R> {

	protected StrategyHandler<T, D, R> defaultStrategyHandler = StrategyHandler.DEFAULT;

	public R router(T requestParameter, D dynamicContext) throws Exception {
		StrategyHandler<T, D, R> strategyHandler = get(requestParameter, dynamicContext);
		if (null != strategyHandler)
			return strategyHandler.apply(requestParameter, dynamicContext);
		return defaultStrategyHandler.apply(requestParameter, dynamicContext);
	}

	@Override
	public R apply(T requestParameter, D dynamicContext) throws Exception {
		// 异步加载数据
		multiThread(requestParameter, dynamicContext);
		// 业务流程受理
		return doApply(requestParameter, dynamicContext);
	}

	/**
	 * 异步加载数据
	 */
	protected abstract void multiThread(T requestParameter, D dynamicContext) throws ExecutionException, InterruptedException, TimeoutException;

	/**
	 * 业务流程受理
	 */
	protected abstract R doApply(T requestParameter, D dynamicContext) throws Exception;

	public StrategyHandler<T, D, R> getDefaultStrategyHandler() {
		return defaultStrategyHandler;
	}

	public void setDefaultStrategyHandler(StrategyHandler<T, D, R> defaultStrategyHandler) {
		this.defaultStrategyHandler = defaultStrategyHandler;
	}

}
