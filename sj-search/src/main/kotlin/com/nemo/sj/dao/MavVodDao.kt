package com.nemo.sj.dao

import com.nemo.sj.repo.MacVod
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository

/**
 *  create by Nemo
 *  2018/6/11  14:24
 */
interface MavVodSearchDao : ElasticsearchRepository<MacVod,Int> {
}