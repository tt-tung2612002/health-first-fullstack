import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/app-layout/src/vaadin-app-layout.js';
import '@vaadin/app-layout/src/vaadin-drawer-toggle.js';

@customElement('my-view')
export class MyView extends LitElement {
  static get styles() {
    return css`
      :host {
          display: block;
          height: 100%;
      }
      `;
  }

  render() {
    return html`
<vaadin-app-layout id="vaadinAppLayout" overlay>
 <vaadin-drawer-toggle tabindex="0"></vaadin-drawer-toggle>
</vaadin-app-layout>
`;
  }

  // Remove this method to render the contents of this view inside Shadow DOM
  createRenderRoot() {
    return this;
  }
}
