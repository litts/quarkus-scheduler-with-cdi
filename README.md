# quarkus-scheduler-with-cdi project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

This project shows an example of using quarkus with quartz to offload rest request to a background process (quartz job) to process in batch mode. It also demostrate the use of qute component to facilitate emailing capabilities using jobs (quartz)

In order to be abe to inject a bean from within a job annotate with @Unremovable refer to https://quarkus.io/guides/cdi-reference#remove_unused_beans
