package chat

import akka.actor.ActorSystem
import akka.contrib.pattern.DistributedPubSubExtension
import akka.contrib.pattern.DistributedPubSubMediator.Subscribe
import akka.testkit.TestKit
import org.scalatest.{BeforeAndAfterAll, Matchers, WordSpecLike}

class ChatClientSpec extends TestKit(ActorSystem("ChatClientSpec"))
  with Matchers with WordSpecLike with BeforeAndAfterAll {

  override def afterAll = TestKit.shutdownActorSystem(system)

  "A ChatClient" should {

    "publish messages to chatroom topic" in {
      val mediator = DistributedPubSubExtension(system).mediator
      mediator ! Subscribe("chatroom", testActor)
      val chatClient = system.actorOf(ChatClient.props("user1"))
      chatClient ! ChatClient.Publish("hello")
      val msg = expectMsgType[ChatClient.Message]
      msg.from should be("user1")
      msg.text should be("hello")
    }

  }

}