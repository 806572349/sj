package com.neme.sj.dao

import com.neme.sj.repo.MacVod
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository

/**
 *  create by Nemo
 *  2018/6/11  14:24
 */
interface MavVodDao : ElasticsearchRepository<MacVod,Int> {
}