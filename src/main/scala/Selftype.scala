trait User2 {
    def username: String
}

trait Tweeter {
     this: User2 => //reassign this
    def tweet(tweetText: String) = println(s"$username: $tweetText")
}

class VerifiedTweeter(val username_ : String) extends Tweeter with User2 {
    def username = s"real $username_"
}
