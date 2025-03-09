package com.andyadc.marketing.domain.group.tag.service;

/**
 * 人群标签服务接口
 */
public interface TagService {

	/**
	 * 执行人群标签批次任务
	 *
	 * @param tagId   人群ID
	 * @param batchId 批次ID
	 */
	void executeTagBatchJob(String tagId, String batchId);

}
