(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["reportes-reportes-module"],{

/***/ "DNQ9":
/*!******************************************************!*\
  !*** ./src/app/pages/reportes/reportes.component.ts ***!
  \******************************************************/
/*! exports provided: ReportesComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ReportesComponent", function() { return ReportesComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "fXoL");
/* harmony import */ var src_app_shared_services_reportes_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! src/app/shared/services/reportes.service */ "mfEs");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/common */ "ofXK");



function ReportesComponent_div_1_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "div", 3);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](2, "img", 4);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "div", 5);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "span", 6);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](5);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](6, "div", 7);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](7);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](8, "p");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](9);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](10, "div", 8);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](11, "p", 9);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](12, "div", 10);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](13, "span");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](14);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](15, "small");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](16);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const item_r1 = ctx.$implicit;
    const i_r2 = ctx.index;
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("src", item_r1.image, _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsanitizeUrl"]);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](item_r1.categoria);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpropertyInterpolate1"]("id", "titulo", i_r2, "");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](item_r1.titulo);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](item_r1.contenido);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpropertyInterpolate"]("title", item_r1.autor.substr(0, 1));
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](item_r1.autor);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](item_r1.actualizado);
} }
class ReportesComponent {
    constructor(reportesService) {
        this.reportesService = reportesService;
        this.reportes = [];
    }
    ngOnInit() {
        this.reportesService.reportesLista().subscribe((response) => {
            Object.assign(this.reportes, response);
        });
    }
}
ReportesComponent.ɵfac = function ReportesComponent_Factory(t) { return new (t || ReportesComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](src_app_shared_services_reportes_service__WEBPACK_IMPORTED_MODULE_1__["ReportesService"])); };
ReportesComponent.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({ type: ReportesComponent, selectors: [["app-reportes"]], decls: 2, vars: 2, consts: [["id", "root", 1, "container", 3, "title"], ["class", "card m-2", 4, "ngFor", "ngForOf"], [1, "card", "m-2"], [1, "image-container"], ["alt", "", 3, "src"], [1, "card-content"], [1, "tag"], [1, "title", 3, "id"], [1, "user"], [3, "title"], [1, "user-info"]], template: function ReportesComponent_Template(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](1, ReportesComponent_div_1_Template, 17, 8, "div", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    } if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpropertyInterpolate"]("title", ctx.reportes.length);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngForOf", ctx.reportes);
    } }, directives: [_angular_common__WEBPACK_IMPORTED_MODULE_2__["NgForOf"]], styles: [".container[_ngcontent-%COMP%] {\n  display: flex;\n  justify-content: center;\n  flex-wrap: wrap;\n  margin-top: 4rem;\n}\n\np[title][_ngcontent-%COMP%]:before {\n  content: attr(title);\n  display: inline-block;\n  font-size: 1em;\n  width: 2.5em;\n  height: 2.5em;\n  line-height: 2.5em;\n  text-align: center;\n  border-radius: 50%;\n  vertical-align: middle;\n  margin-right: 1em;\n  color: white;\n  background: #56ad5b;\n}\n\n.card[_ngcontent-%COMP%] {\n  max-width: 300px;\n  height: 430px;\n  position: relative;\n  background: #fff;\n  border-radius: 5px;\n}\n\n.card[_ngcontent-%COMP%]:hover {\n  box-shadow: 2px 2px 6px 5px rgba(0, 0, 0, 0.2);\n}\n\n.card[_ngcontent-%COMP%]   .image-container[_ngcontent-%COMP%] {\n  position: relative;\n  width: 100%;\n  height: 180px;\n}\n\n.card[_ngcontent-%COMP%]   img[_ngcontent-%COMP%] {\n  position: absolute;\n  top: 0;\n  left: 0;\n  width: 100%;\n  height: 100%;\n  filter: brightness(0.8);\n  border-top-left-radius: 5px;\n  border-top-right-radius: 5px;\n  object-fit: cover;\n  transition: 0.2s ease-in-out;\n}\n\n.card[_ngcontent-%COMP%]:hover   img[_ngcontent-%COMP%] {\n  filter: brightness(1);\n}\n\n.card-content[_ngcontent-%COMP%] {\n  \n  padding: 15px 20px;\n  flex-direction: column;\n  padding-bottom: 10px;\n}\n\n.tag[_ngcontent-%COMP%] {\n  background: red;\n  padding: 1px 7px;\n  font-size: 12px;\n  color: #fff;\n  border-radius: 40px;\n}\n\n.title[_ngcontent-%COMP%] {\n  font-weight: bold;\n  margin-top: 5px;\n}\n\n.card[_ngcontent-%COMP%]   p[_ngcontent-%COMP%] {\n  font-size: 12px;\n  margin-top: 10px;\n  font-weight: 300;\n}\n\n.user[_ngcontent-%COMP%] {\n  position: absolute;\n  bottom: 10px;\n  right: 20px;\n  left: 20px;\n  display: flex;\n  align-items: center;\n  gap: 10px;\n  margin-top: 10px;\n  padding-top: 10px;\n  border-top: 1px solid rgba(0, 0, 0, 0.1);\n}\n\n.user[_ngcontent-%COMP%]   .user-img[_ngcontent-%COMP%] {\n  background: blue;\n  width: 40px;\n  height: 40px;\n  border-radius: 50%;\n}\n\n.user[_ngcontent-%COMP%]   .user-info[_ngcontent-%COMP%] {\n  display: flex;\n  flex-direction: column;\n  letter-spacing: 1px;\n}\n\n.user[_ngcontent-%COMP%]   .user-info[_ngcontent-%COMP%]   small[_ngcontent-%COMP%] {\n  font-size: 11px;\n}\n\n.user[_ngcontent-%COMP%]   .user-info[_ngcontent-%COMP%]   span[_ngcontent-%COMP%] {\n  font-weight: bold;\n  font-size: 14px;\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIi4uXFwuLlxcLi5cXC4uXFxyZXBvcnRlcy5jb21wb25lbnQuc2NzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFDQTtFQUNFLGFBQUE7RUFDQSx1QkFBQTtFQUNBLGVBQUE7RUFDQSxnQkFBQTtBQUFGOztBQUlBO0VBQ0Usb0JBQUE7RUFDQSxxQkFBQTtFQUNBLGNBQUE7RUFDQSxZQUFBO0VBQ0EsYUFBQTtFQUNBLGtCQUFBO0VBQ0Esa0JBQUE7RUFDQSxrQkFBQTtFQUNBLHNCQUFBO0VBQ0EsaUJBQUE7RUFDQSxZQUFBO0VBQ0EsbUJBQUE7QUFERjs7QUFJQTtFQUNFLGdCQUFBO0VBQ0EsYUFBQTtFQUNBLGtCQUFBO0VBQ0EsZ0JBQUE7RUFDQSxrQkFBQTtBQURGOztBQUlBO0VBQ0ksOENBQUE7QUFESjs7QUFHQTtFQUNFLGtCQUFBO0VBQ0MsV0FBQTtFQUNELGFBQUE7QUFBRjs7QUFFQTtFQUNFLGtCQUFBO0VBQ0EsTUFBQTtFQUNBLE9BQUE7RUFDQSxXQUFBO0VBQ0EsWUFBQTtFQUNBLHVCQUFBO0VBQ0EsMkJBQUE7RUFDQSw0QkFBQTtFQUNBLGlCQUFBO0VBQ0EsNEJBQUE7QUFDRjs7QUFDQTtFQUNJLHFCQUFBO0FBRUo7O0FBQUE7RUFDQSxvQkFBQTtFQUNFLGtCQUFBO0VBQ0Esc0JBQUE7RUFDQSxvQkFBQTtBQUdGOztBQURBO0VBQ0UsZUFBQTtFQUNBLGdCQUFBO0VBQ0EsZUFBQTtFQUNBLFdBQUE7RUFDQSxtQkFBQTtBQUlGOztBQUZBO0VBQ0UsaUJBQUE7RUFDQSxlQUFBO0FBS0Y7O0FBSEE7RUFDRSxlQUFBO0VBQ0EsZ0JBQUE7RUFDQSxnQkFBQTtBQU1GOztBQUhBO0VBQ0Usa0JBQUE7RUFDQSxZQUFBO0VBQ0EsV0FBQTtFQUNBLFVBQUE7RUFDQSxhQUFBO0VBQ0EsbUJBQUE7RUFDQSxTQUFBO0VBQ0EsZ0JBQUE7RUFDQSxpQkFBQTtFQUNBLHdDQUFBO0FBTUY7O0FBSkE7RUFDRSxnQkFBQTtFQUNBLFdBQUE7RUFDQSxZQUFBO0VBQ0Esa0JBQUE7QUFPRjs7QUFMQTtFQUNFLGFBQUE7RUFDQSxzQkFBQTtFQUNBLG1CQUFBO0FBUUY7O0FBTkE7RUFDRSxlQUFBO0FBU0Y7O0FBUEE7RUFDRSxpQkFBQTtFQUNBLGVBQUE7QUFVRiIsImZpbGUiOiJyZXBvcnRlcy5jb21wb25lbnQuc2NzcyIsInNvdXJjZXNDb250ZW50IjpbIlxyXG4uY29udGFpbmVye1xyXG4gIGRpc3BsYXk6ZmxleDtcclxuICBqdXN0aWZ5LWNvbnRlbnQ6Y2VudGVyO1xyXG4gIGZsZXgtd3JhcDp3cmFwO1xyXG4gIG1hcmdpbi10b3A6IDRyZW07XHJcbn1cclxuXHJcblxyXG5wW3RpdGxlXTpiZWZvcmUge1xyXG4gIGNvbnRlbnQ6YXR0cih0aXRsZSk7XHJcbiAgZGlzcGxheTppbmxpbmUtYmxvY2s7XHJcbiAgZm9udC1zaXplOjFlbTtcclxuICB3aWR0aDoyLjVlbTtcclxuICBoZWlnaHQ6Mi41ZW07XHJcbiAgbGluZS1oZWlnaHQ6Mi41ZW07XHJcbiAgdGV4dC1hbGlnbjpjZW50ZXI7XHJcbiAgYm9yZGVyLXJhZGl1czo1MCU7XHJcbiAgdmVydGljYWwtYWxpZ246bWlkZGxlO1xyXG4gIG1hcmdpbi1yaWdodDoxZW07XHJcbiAgY29sb3I6d2hpdGU7XHJcbiAgYmFja2dyb3VuZDojNTZhZDViO1xyXG59XHJcblxyXG4uY2FyZHtcclxuICBtYXgtd2lkdGg6MzAwcHg7XHJcbiAgaGVpZ2h0OjQzMHB4O1xyXG4gIHBvc2l0aW9uOnJlbGF0aXZlO1xyXG4gIGJhY2tncm91bmQ6I2ZmZjtcclxuICBib3JkZXItcmFkaXVzOjVweDtcclxufVxyXG5cclxuLmNhcmQ6aG92ZXJ7XHJcbiAgICBib3gtc2hhZG93OjJweCAycHggNnB4IDVweCByZ2JhKDAsMCwwLC4yKTtcclxufVxyXG4uY2FyZCAuaW1hZ2UtY29udGFpbmVye1xyXG4gIHBvc2l0aW9uOnJlbGF0aXZlO1xyXG4gICB3aWR0aDoxMDAlO1xyXG4gIGhlaWdodDoxODBweDtcclxufVxyXG4uY2FyZCBpbWd7XHJcbiAgcG9zaXRpb246YWJzb2x1dGU7XHJcbiAgdG9wOjA7XHJcbiAgbGVmdDowO1xyXG4gIHdpZHRoOjEwMCU7XHJcbiAgaGVpZ2h0OjEwMCU7XHJcbiAgZmlsdGVyOmJyaWdodG5lc3MoLjgpO1xyXG4gIGJvcmRlci10b3AtbGVmdC1yYWRpdXM6NXB4O1xyXG4gIGJvcmRlci10b3AtcmlnaHQtcmFkaXVzOjVweDtcclxuICBvYmplY3QtZml0OmNvdmVyO1xyXG4gIHRyYW5zaXRpb246LjJzIGVhc2UtaW4tb3V0O1xyXG59XHJcbi5jYXJkOmhvdmVyIGltZ3tcclxuICAgIGZpbHRlcjpicmlnaHRuZXNzKDEpO1xyXG59XHJcbi5jYXJkLWNvbnRlbnQge1xyXG4vKiAgIGRpc3BsYXk6ZmxleDsgKi9cclxuICBwYWRkaW5nOjE1cHggMjBweDtcclxuICBmbGV4LWRpcmVjdGlvbjpjb2x1bW47XHJcbiAgcGFkZGluZy1ib3R0b206MTBweDtcclxufVxyXG4udGFne1xyXG4gIGJhY2tncm91bmQ6cmVkO1xyXG4gIHBhZGRpbmc6MXB4IDdweDtcclxuICBmb250LXNpemU6MTJweDtcclxuICBjb2xvcjojZmZmO1xyXG4gIGJvcmRlci1yYWRpdXM6NDBweDtcclxufVxyXG4udGl0bGV7XHJcbiAgZm9udC13ZWlnaHQ6Ym9sZDtcclxuICBtYXJnaW4tdG9wOjVweDtcclxufVxyXG4uY2FyZCBwe1xyXG4gIGZvbnQtc2l6ZToxMnB4O1xyXG4gIG1hcmdpbi10b3A6MTBweDtcclxuICBmb250LXdlaWdodDozMDA7XHJcbn1cclxuXHJcbi51c2Vye1xyXG4gIHBvc2l0aW9uOmFic29sdXRlO1xyXG4gIGJvdHRvbToxMHB4O1xyXG4gIHJpZ2h0OjIwcHg7XHJcbiAgbGVmdDoyMHB4O1xyXG4gIGRpc3BsYXk6ZmxleDtcclxuICBhbGlnbi1pdGVtczpjZW50ZXI7XHJcbiAgZ2FwOjEwcHg7XHJcbiAgbWFyZ2luLXRvcDoxMHB4O1xyXG4gIHBhZGRpbmctdG9wOjEwcHg7XHJcbiAgYm9yZGVyLXRvcDoxcHggc29saWQgcmdiYSgwLDAsMCwuMSk7XHJcbn1cclxuLnVzZXIgLnVzZXItaW1ne1xyXG4gIGJhY2tncm91bmQ6Ymx1ZTtcclxuICB3aWR0aDo0MHB4O1xyXG4gIGhlaWdodDo0MHB4O1xyXG4gIGJvcmRlci1yYWRpdXM6NTAlO1xyXG59XHJcbi51c2VyIC51c2VyLWluZm8ge1xyXG4gIGRpc3BsYXk6ZmxleDtcclxuICBmbGV4LWRpcmVjdGlvbjpjb2x1bW47XHJcbiAgbGV0dGVyLXNwYWNpbmc6MXB4O1xyXG59XHJcbi51c2VyIC51c2VyLWluZm8gc21hbGx7XHJcbiAgZm9udC1zaXplOjExcHg7XHJcbn1cclxuLnVzZXIgLnVzZXItaW5mbyBzcGFue1xyXG4gIGZvbnQtd2VpZ2h0OmJvbGQ7XHJcbiAgZm9udC1zaXplOjE0cHg7XHJcbn1cclxuIl19 */"] });


/***/ }),

/***/ "jxU4":
/*!***********************************************************!*\
  !*** ./src/app/pages/reportes/reportes-routing.module.ts ***!
  \***********************************************************/
/*! exports provided: ReportesRoutingModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ReportesRoutingModule", function() { return ReportesRoutingModule; });
/* harmony import */ var _reportes_component__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./reportes.component */ "DNQ9");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ "tyNb");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/core */ "fXoL");




const routes = [{
        path: '',
        component: _reportes_component__WEBPACK_IMPORTED_MODULE_0__["ReportesComponent"],
        children: []
    }];
class ReportesRoutingModule {
}
ReportesRoutingModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdefineNgModule"]({ type: ReportesRoutingModule });
ReportesRoutingModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdefineInjector"]({ factory: function ReportesRoutingModule_Factory(t) { return new (t || ReportesRoutingModule)(); }, imports: [[_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forChild(routes)], _angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]] });
(function () { (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵsetNgModuleScope"](ReportesRoutingModule, { imports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]], exports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]] }); })();


/***/ }),

/***/ "s6Id":
/*!***************************************************!*\
  !*** ./src/app/pages/reportes/reportes.module.ts ***!
  \***************************************************/
/*! exports provided: ReportesModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ReportesModule", function() { return ReportesModule; });
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/common */ "ofXK");
/* harmony import */ var _reportes_routing_module__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./reportes-routing.module */ "jxU4");
/* harmony import */ var _reportes_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./reportes.component */ "DNQ9");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/core */ "fXoL");




class ReportesModule {
}
ReportesModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdefineNgModule"]({ type: ReportesModule });
ReportesModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdefineInjector"]({ factory: function ReportesModule_Factory(t) { return new (t || ReportesModule)(); }, imports: [[
            _angular_common__WEBPACK_IMPORTED_MODULE_0__["CommonModule"],
            _reportes_routing_module__WEBPACK_IMPORTED_MODULE_1__["ReportesRoutingModule"]
        ]] });
(function () { (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵsetNgModuleScope"](ReportesModule, { declarations: [_reportes_component__WEBPACK_IMPORTED_MODULE_2__["ReportesComponent"]], imports: [_angular_common__WEBPACK_IMPORTED_MODULE_0__["CommonModule"],
        _reportes_routing_module__WEBPACK_IMPORTED_MODULE_1__["ReportesRoutingModule"]] }); })();


/***/ })

}]);
//# sourceMappingURL=reportes-reportes-module.js.map