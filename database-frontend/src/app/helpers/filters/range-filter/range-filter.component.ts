import { Component, Input } from '@angular/core'
import { ClrDatagridFilterInterface } from '@clr/angular'
import { Subject } from 'rxjs'

export interface RangeParam {
  min: number
  max: number
}

@Component({
  selector: 'app-range-filter',
  templateUrl: './range-filter.component.html',
  styleUrls: ['./range-filter.component.css']
})

export class RangeFilterComponent implements ClrDatagridFilterInterface<any> {
  private _types: Map<number, RangeParam>
  selected: number[] = [] // selected keys
  changes = new Subject<any>()

  constructor() {
  }

  get types() {
    return this._types
  }

  @Input('clrFilterValue') field

  @Input('clrRangeValue')
  set type(val: RangeParam[]) {
    let i = 0
    this._types = new Map
    val.forEach(el => {
      this._types.set(i++, el)
    })
  }

  accepts(item: any): boolean {
    let res = false
    const itemValue = +item[this.field]
    this.selected.forEach(key => {
      const param: RangeParam = this._types.get(+key)
      if (itemValue>= param.min && itemValue <= param.max) res = res || true
    })
    return res
  }

  select(event: any) {
    const value = event.target.value
    if (event.target.checked) {
      this.selected.push(value)
    } else {
      const index = this.selected.indexOf(value)
      if (index > -1) this.selected.splice(index, 1)
    }
    this.changes.next(true)
  }

  isActive(): boolean {
    return this.selected.length > 0
  }

}
