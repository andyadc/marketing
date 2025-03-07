package com.andyadc.marketing.infrastructure.repository;

import com.andyadc.marketing.domain.strategy.repository.StrategyRepository;
import com.andyadc.marketing.infrastructure.persistence.marketing.mapper.DrawActivityAccountDayMapper;
import com.andyadc.marketing.infrastructure.persistence.marketing.mapper.DrawActivityAccountMapper;
import com.andyadc.marketing.infrastructure.persistence.marketing.mapper.DrawActivityMapper;
import com.andyadc.marketing.infrastructure.persistence.marketing.mapper.RuleTreeMapper;
import com.andyadc.marketing.infrastructure.persistence.marketing.mapper.RuleTreeNodeLineMapper;
import com.andyadc.marketing.infrastructure.persistence.marketing.mapper.RuleTreeNodeMapper;
import com.andyadc.marketing.infrastructure.persistence.marketing.mapper.StrategyAwardMapper;
import com.andyadc.marketing.infrastructure.persistence.marketing.mapper.StrategyMapper;
import com.andyadc.marketing.infrastructure.persistence.marketing.mapper.StrategyRuleMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class StrategyRepositoryImpl implements StrategyRepository {

	private static final Logger logger = LoggerFactory.getLogger(StrategyRepositoryImpl.class);

	private DrawActivityMapper drawActivityMapper;
	private DrawActivityAccountMapper drawActivityAccountMapper;
	private DrawActivityAccountDayMapper drawActivityAccountDayMapper;
	private StrategyMapper strategyMapper;
	private StrategyRuleMapper strategyRuleMapper;
	private StrategyAwardMapper strategyAwardMapper;
	private RuleTreeMapper ruleTreeMapper;
	private RuleTreeNodeMapper ruleTreeNodeMapper;
	private RuleTreeNodeLineMapper ruleTreeNodeLineMapper;


}
