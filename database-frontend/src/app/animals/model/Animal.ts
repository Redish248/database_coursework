export interface Animal {
  id: string
  name: string
  gender: string
  weight: number
  age: number
  dateOfArrival: string
  placeOfArrival: string
  furColor: string
  eyesColor: string
  animalType: AnimalType
  photo: [] // byte array
  passport: Passport
  newOwner: Owner
  previousOwner: Owner
  feed: Feed[]
  animalTypeInfo: AnimalTypeInfo
  additionalCharacteristics: Characteristic[]
}

export enum AnimalType {
  CAT = "кошачьи",
  DOG = "собака",
  BIRD = "птица",
  RODENT = "грызун"
}

export interface Passport {
  number: string
  officialName: string
}

export interface Owner {
  uid: number
  fullName: string
  surname: string
  phone: string
  email: string
  address: string
}

export interface Feed {
  uid: number
  amountInGramm: number
}

export interface AnimalTypeInfo {
  typicalIllnesses: Characteristic[]
  habits: Characteristic[]
  additionalInfo: Characteristic[]
}

export interface Characteristic {
  name: string
  description: string
}
