import { NgModule } from '@angular/core'
import { CommonModule } from '@angular/common'
import { SelectFilterComponent } from './select-filter/select-filter.component'
import { ClarityModule } from '@clr/angular'
import { ReactiveFormsModule } from '@angular/forms'
import { RangeFilterComponent } from './range-filter/range-filter.component'


@NgModule({
  declarations: [SelectFilterComponent, RangeFilterComponent],
  imports: [
    CommonModule, ClarityModule, ReactiveFormsModule
  ],
  exports: [SelectFilterComponent, RangeFilterComponent]
})
export class FilterModule {
}
