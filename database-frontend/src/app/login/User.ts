export interface User{
  name: string
}

export class UserInfo {
  uid: bigint
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
  uid: bigint
  name: string
  description: string
}
