package web.rulemanage.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.rulemanage.common.BaseResponse;
import web.rulemanage.common.ResultUtils;
import web.rulemanage.domain.Companies;
import web.rulemanage.domain.News;
import web.rulemanage.service.CompaniesService;
import web.rulemanage.service.NewsService;

@RestController
@RequestMapping
@CrossOrigin(origins = "https://127.0.0.1:5173",allowCredentials = "true")
public class NewsController {
    @Resource
    private NewsService newsService;

    @GetMapping("/News/find")
    public BaseResponse<News> findNews(String newsid){
        News news = newsService.findNews(newsid);
        return ResultUtils.success(news);
    }
    @GetMapping("/News/pageList")
    public BaseResponse<Page<News>> findAllNews(long pageSize, long pageNum){
        QueryWrapper<News> queryWrapper = new QueryWrapper<>();
        Page<News> newsPage = newsService.page(new Page<>(pageNum, pageSize), queryWrapper);
        return ResultUtils.success(newsPage);
    }

}
