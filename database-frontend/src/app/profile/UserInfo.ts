export class UserInfo {
  uid: number
  nick: string
  name: string
  surname: string
  dateOfBirth: Date
  gender: string
  email: string
  password: string
  userType: UserType
}

class UserType {
  uid: number
  name: string
  description: string
}
