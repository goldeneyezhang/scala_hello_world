abstract class Notification

case class Email(sender: String, title: String, body: String) extends Notification

case class SMS(caller: String, message: String) extends Notification

case class VoiceRecording(contactName: String, link: String) extends Notification

object Pattern {
    def showNotification(notification: Notification): String = {
    notification match {
        case Email(email, title, _) =>
            s"You got an email from $email with title: $title"
        case SMS(number, message) =>
            s"You got an SMS from $number! Message: $message"
        case VoiceRecording(name, link) =>
            s"you received a Voice Recording from $name! Click the link to hear it: $link"
        }
    }
    def showImportantNotification(notification: Notification, importantPeopleInfo: Seq[String]): String = {
        notification match {
            case Email(email, _, _) if importantPeopleInfo.contains(email) =>
                "You got an email from special someone!"
            case SMS(number, _) if importantPeopleInfo.contains(number) =>
                "You got an SMS from special someone!"
            case other =>
                showNotification(other) //nothing special, deleate to our original showNotification function

        }
    }
    def goIdle(device: Device) = device match {
        case p: Phone => p.screenOff
        case c: Computer => c.screenSaverOn
    }
}

abstract class Device
case class Phone(model: String) extends Device {
    def screenOff = "Turning screen off"
}
case class Computer(model: String) extends Device {
    def screenSaverOn ="Turning screen saver on..."
}
