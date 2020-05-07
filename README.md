
# Kafka streams examples with spring cloud streams
Spring Cloud Stream applications that communicate using Kafka.

The scenario is a cell phone company creating bills for its customers. Each call made by a user has a  `duration`  and an amount of  `data`  used during the call. As part of the process to generate a bill, the raw call data needs to be converted to a cost for the duration of the call and a cost for the amount of data used.

The call is modeled by using the  `UsageDetail`  class, which contains the  `duration`  of the call and the amount of  `data`  used during the call. The bill is modeled by using the  `UsageCostDetail`  class, which contains the cost of the call (`costCall`) and the cost of the data (`costData`). Each class contains an ID (`userId`) to identify the person making the call.

## Building the apps  
  
```bash  
$./mvnw clean package  
```  
  
## Building the distribution  
  
```bash  
$./mvnw package -Pdist  
  
```  
  
This must be run from this directory and will build `dist/usage-cost-stream-kafka.zip`

## Deployment
When you deploy these three applications (`UsageDetailSender`,  `UsageCostProcessor`  and  `UsageCostLogger`), the flow of message is as follows:

```text
UsageDetailSender -> UsageCostProcessor -> UsageCostLogger
```
The  `UsageDetailSender`  source application's output is connected to the  `UsageCostProcessor`  processor application's input. The  `UsageCostProcessor`  application's output is connected to the  `UsageCostLogger`  sink application's input.

When these applications run, the  `Kafka`  binder binds the applications' output and input boundaries to the corresponding topics in Kafka.