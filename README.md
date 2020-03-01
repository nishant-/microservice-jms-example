# microservice-jms-example

Microservice communication via JMS using activemq broker.

Required softwares:

1. Apache ActiveMQ Broker
2. MongoDB

Producer microservice will send a messag to a JMS Queue.
Consumer microservice listens for messages on the queue, as soon as it is available, receives it, and, stores its contents in a mongodb database.

Producer runs on port 8120 and consumer on 8121.

use endpoint - http://localhost:8120/ to post messages to the queue.
<br>
<br>
JSON payload for message:
<br>
<br>
{
<br>
	"from": "XXXXX",
<br>
	"to": "YYYYY",
<br>
	"text": "Sample message"
<br>
}
<br>
display all the messages using the end-point - http://localhost:8121/all/

