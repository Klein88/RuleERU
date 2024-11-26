package web.rulemanage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import web.rulemanage.domain.Companies;
import web.rulemanage.domain.News;
import web.rulemanage.mapper.CompaniesMapper;
import web.rulemanage.service.NewsService;
import web.rulemanage.mapper.NewsMapper;
import org.springframework.stereotype.Service;

/**
* @author xpc
* @description 针对表【News】的数据库操作Service实现
* @createDate 2023-11-12 16:16:01
*/
@Service
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News>
    implements NewsService{
    @Resource
    private NewsMapper newsMapper;

    @Override
    public News findNews(String NewsID) {
        QueryWrapper<News> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(NewsID)) {
            queryWrapper.eq("NewsID", NewsID);
        }
        return newsMapper.selectOne(queryWrapper);
    }
}




