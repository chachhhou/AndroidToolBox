package fr.isen.suarez.androidtoolbox.Models


class RandomUserResult {
    var results: ArrayList<User>? = null
}


class User (
    var gender: String? ,
    var name: Name?,
    var email: String?,
    var picture: Picture?
)

class Name (
    var title: String?,
    var first: String?,
    var last: String?
)

class Picture (
    var large: String?
)

