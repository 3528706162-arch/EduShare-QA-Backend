package org.example.edushare_qa.Service;

import java.util.List;
import java.util.Map;

public interface ReportService {

    int userCount();

    int resourceCount();

    int questionCount();

    int answerCount();

    List<Map<String, Integer>> identityCount();

    List<Map<String, Integer>> userCountByTime();
}
