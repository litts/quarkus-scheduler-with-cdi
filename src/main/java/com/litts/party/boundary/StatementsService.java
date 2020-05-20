package com.litts.party.boundary;

import io.quarkus.arc.Unremovable;
import io.quarkus.mailer.MailTemplate;
import io.quarkus.qute.api.ResourcePath;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@Unremovable
public class StatementsService {

  @ResourcePath("statementTemplate")
  MailTemplate statementTemplate;

  public void generateAndEmailStatements() {
    // some work

    statementTemplate
        .to("someemail@gmail.com")
        .subject("Monthly Statement")
        .data("title", "June Statement")
        .data("name", "Client Name")
        .send();
  }
}
