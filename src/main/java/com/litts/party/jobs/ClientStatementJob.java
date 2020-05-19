package com.litts.party.jobs;

import com.litts.party.boundary.StatementsService;
import io.quarkus.arc.Arc;
import io.quarkus.arc.ManagedContext;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class ClientStatementJob implements Job {

  @Override
  public void execute(final JobExecutionContext context) throws JobExecutionException {
    ManagedContext requestContext = Arc.container().requestContext();
    if (!requestContext.isActive()) {
      requestContext.activate();
    }
    // returns null
    StatementsService statementsService = Arc.container().instance(StatementsService.class).get();
    statementsService.generateAndEmailStatements();
  }
}
