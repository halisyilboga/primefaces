/*
 * Copyright 2009-2013 PrimeTek.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.primefaces.mobile.component.rangeslider;

import java.io.IOException;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import org.primefaces.renderkit.CoreRenderer;

public class RangeSliderRenderer extends CoreRenderer {
    
    @Override
    public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        RangeSlider rangeSlider = (RangeSlider) component;
        String clientId = rangeSlider.getClientId(context);
        String style = rangeSlider.getStyle();
        String styleClass = rangeSlider.getStyleClass();
        
        writer.startElement("div", component);
        writer.writeAttribute("data-role", "rangeslider", null);
        if (shouldWriteId(rangeSlider)) writer.writeAttribute("id", clientId, "id");
        if (style != null) writer.writeAttribute("style", style, null);  
        if (styleClass != null) writer.writeAttribute("class", styleClass, null); 
        if (!rangeSlider.isHighlight()) writer.writeAttribute("data-highlight", "false", null);
    }
    
    @Override
    public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
        context.getResponseWriter().endElement("div");
    }
}