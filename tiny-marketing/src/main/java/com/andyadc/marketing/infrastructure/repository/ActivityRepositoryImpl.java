package com.andyadc.marketing.infrastructure.repository;

import com.andyadc.marketing.domain.activity.repository.ActivityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class ActivityRepositoryImpl implements ActivityRepository {

	private static final Logger logger = LoggerFactory.getLogger(ActivityRepositoryImpl.class);

}
