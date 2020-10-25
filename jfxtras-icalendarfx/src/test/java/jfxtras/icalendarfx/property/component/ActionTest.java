/**
 * Copyright (c) 2011-2020, JFXtras
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *    Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *    Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *    Neither the name of the organization nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL JFXRAS BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package jfxtras.icalendarfx.property.component;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import jfxtras.icalendarfx.properties.component.alarm.Action;
import jfxtras.icalendarfx.properties.component.alarm.Action.ActionType;

public class ActionTest
{
    @Test
    public void canParseAction()
    {
        Action madeProperty = Action.parse("ACTION:AUDIO");
        String expectedContent = "ACTION:AUDIO";
        assertEquals(expectedContent, madeProperty.toString());
        assertEquals(ActionType.AUDIO, madeProperty.getValue());
    }
    
    @Test
    public void canParseAction2()
    {
        Action madeProperty = new Action(ActionType.DISPLAY);
        String expectedContent = "ACTION:DISPLAY";
        assertEquals(expectedContent, madeProperty.toString());
        assertEquals(ActionType.DISPLAY, madeProperty.getValue());
    }
    
    @Test
    public void canParseAction3()
    {
        Action madeProperty = Action.parse("DANCE");
        String expectedContent = "ACTION:DANCE";
        assertEquals(expectedContent, madeProperty.toString());
        assertEquals(ActionType.UNKNOWN, madeProperty.getValue());
    }
    
    @Test
    public void canParseAction4()
    {
        Action madeProperty = Action.parse("EMAIL");
        String expectedContent = "ACTION:EMAIL";
        assertEquals(expectedContent, madeProperty.toString());
        assertEquals(ActionType.EMAIL, madeProperty.getValue());
        Action copiedProperty = new Action(madeProperty);
        assertEquals(madeProperty, copiedProperty);
        assertFalse(copiedProperty == madeProperty);
    }
}
