package com.litts.party.jobs;

import com.litts.party.boundary.StatementsService;
import javax.inject.Inject;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class ClientStatementJob implements Job {

  @Inject StatementsService statementService;

  @Override
  public void execute(final JobExecutionContext context) throws JobExecutionException {
    statementService.generateAndEmailStatements();
  }
}
