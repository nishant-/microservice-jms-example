# microservice-jms-example

Microservice communication via JMS using activemq broker.

Required softwares:

1. Apache ActiveMQ Broker
2. MongoDB

producer microservice will send a messaghttp://localhost:8121/all/e to a JMS Q.
consumer microservice listens for messages on the queue, as soon as it is available, receives it, and, stores it in a mongodb database.

producer runs on port 8120 and consumer on 8121.

use endpoint - http://localhost:8120/ to post messages to the queue.
e.g. JSON payload for message:

{
	"from": "XXXXX",
	"to": "YYYYY",
	"text": "Sample message"
}

display all the messages using the end-point - http://localhost:8121/all/

