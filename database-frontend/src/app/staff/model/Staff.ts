import { Gender } from '../../common_model'
import { Position } from './Position'

export interface Staff {
  uid: number
  name: string
  surname: string
  patronymic: string
  gender: Gender
  dateOfBirth: Date
  positionType: Position
  salary: number
  experience: number
  firstWorkDate: Date
}
