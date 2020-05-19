package com.litts.party.boundary;

import com.litts.party.jobs.ClientStatementJob;
import com.litts.scheduler.control.SchedulerHelper;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import org.quartz.JobDataMap;
import org.quartz.SchedulerException;

@Path("api/party")
@ApplicationScoped
public class PartyResource {
  @Inject SchedulerHelper schedulerHelper;

  @GET
  @Path("/statements")
  public Response sendStatements() throws SchedulerException {
    schedulerHelper.scheduleOnce(20, ClientStatementJob.class, new JobDataMap());
    return Response.ok().build();
  }
}
