#docker-compose run web ping kafka - tova runni za da ima vruzka s kafkata
#http://127.0.0.1:8000/display_orders

from confluent_kafka import Consumer, KafkaException

def run_kafka_consumer():
    consumer_conf = {
        'bootstrap.servers': 'localhost:9092',
        'group.id': 'my_consumer_group',
        'auto.offset.reset': 'earliest'
    }

    consumer = Consumer(consumer_conf)
    consumer.subscribe(['order_placed'])

    try:
        while True:
            msg = consumer.poll(1.0)
            if msg is None:
                continue
            if msg.error():
                if msg.error().code() == KafkaException._PARTITION_EOF:
                    continue
                else:
                    print(f"Error: {msg.error()}")
            else:
                print(f"Received message: {msg.value().decode('utf-8')}")
    except KeyboardInterrupt:
        pass
    finally:
        consumer.close()

if __name__ == '__main__':
    run_kafka_consumer()

