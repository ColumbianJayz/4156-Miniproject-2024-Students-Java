# Welcome Students of 4156

Please follow the assignment specifications on Courseworks when completing this project.

Hello, 

I used pmd. I installed it with homebrew.
The command I ran was "pmd check --dir src --rulesets rulesets/java/quickstart.xml --format text"
At the time of submission these were my results:


(base) jayzmontoya@Jayzs-MacBook-Pro-2 IndividualProject % pmd check --dir src --rulesets rulesets/java/quickstart.xml --format text
[WARN] Progressbar rendering conflicts with reporting to STDOUT. No progressbar will be shown. Try running with argument -r <file> to output the report to a file instead.
[WARN] This analysis could be faster, please consider using Incremental Analysis: https://docs.pmd-code.org/pmd-doc-7.5.0/pmd_userdocs_incremental_analysis.html
(base) jayzmontoya@Jayzs-MacBook-Pro-2 IndividualProject % mvn checkstyle:check
[INFO] Scanning for projects...
[INFO] 
[INFO] ---------------< dev.coms4156.project:IndividualProject >---------------
[INFO] Building IndividualProject 0.0.1-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- checkstyle:3.2.0:check (default-cli) @ IndividualProject ---
[INFO] Starting audit...
Audit done.
[INFO] You have 0 Checkstyle violations.
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.890 s
[INFO] Finished at: 2024-09-13T23:46:59-04:00
[INFO] ------------------------------------------------------------------------
(base) jayzmontoya@Jayzs-MacBook-Pro-2 IndividualProject % 
