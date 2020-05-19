package com.litts.party.boundary;

import io.quarkus.mailer.MailTemplate;
import io.quarkus.qute.api.ResourcePath;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class StatementsService {

  @ResourcePath("statementTemplate")
  MailTemplate statementTemplate;

  public void generateAndEmailStatements() {
    // generate statement - Database access etc
    // email statements to multiple clients

    statementTemplate
        .to("someemail@gmail.com")
        .subject("Monthly Statement")
        .data("title", "June Statement")
        .data("name", "Client Name")
        .send();
  }
}
