package org.example.edushare_qa.Service;


import org.example.edushare_qa.Mapper.ReportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private ReportMapper reportMapper;

    @Override
    public int userCount() {
        return reportMapper.userCount();
    }

    @Override
    public int resourceCount() {
        return reportMapper.resourceCount();
    }

    @Override
    public int questionCount() {
        return reportMapper.questionCount();
    }

    @Override
    public int answerCount() {
        return reportMapper.answerCount();
    }

    @Override
    public List<Map<String, Integer>> identityCount() {
        return reportMapper.identityCount();
    }

    @Override
    public List<Map<String, Integer>> userCountByTime() {
        return reportMapper.userCountByTime();
    }
}
