/**
 * Copyright (c) 2011-2021, JFXtras
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
 * DISCLAIMED. IN NO EVENT SHALL JFXTRAS BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package jfxtras.icalendarfx.parameter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import jfxtras.icalendarfx.parameters.AlternateText;
import jfxtras.icalendarfx.parameters.CalendarUser;
import jfxtras.icalendarfx.parameters.Delegatees;
import jfxtras.icalendarfx.parameters.DirectoryEntry;
import jfxtras.icalendarfx.parameters.FormatType;
import jfxtras.icalendarfx.parameters.GroupMembership;

public class ParseParameterTest
{
    @Test // tests enum as value
    public void canParseCalendarUser()
    {
        CalendarUser parameter = CalendarUser.parse("GROUP");
        String expectedContent = "CUTYPE=GROUP";
        assertEquals(expectedContent, parameter.toString());
    }
    
    @Test // tests list of URI value
    public void canParseDelegatees()
    {
        Delegatees parameter = Delegatees.parse("\"mailto:jdoe@example.com\",\"mailto:jqpublic@example.com\"");
        String expectedContent = "DELEGATED-TO=\"mailto:jdoe@example.com\",\"mailto:jqpublic@example.com\"";
        assertEquals(expectedContent, parameter.toString());
        assertEquals(2, parameter.getValue().size());
    }
    
    @Test // tests single URI as value
    public void canParseAlternateText()
    {
        AlternateText parameter = AlternateText.parse("\"CID:part3.msg.970415T083000@example.com\"");
        String expectedContent = "ALTREP=\"CID:part3.msg.970415T083000@example.com\"";
        assertEquals(expectedContent, parameter.toString());
    }
    
    @Test // tests single URI as value
    public void canParseGroupMembership()
    {
        String expectedContent = "\"mailto:projectA@example.com\",\"mailto:projectB@example.com\"";        
        GroupMembership parameter = GroupMembership.parse(expectedContent);
        assertEquals("MEMBER=" + expectedContent, parameter.toString());
        assertEquals(2, parameter.getValue().size());
    }
    
    @Test // tests list as value
    public void canParseDirectory()
    {
        DirectoryEntry parameter = DirectoryEntry.parse("\"ldap://example.com:6666/o=ABC%20Industries,c=US???(cn=Jim%20Dolittle)\"");
        String expectedContent = "DIR=\"ldap://example.com:6666/o=ABC%20Industries,c=US???(cn=Jim%20Dolittle)\"";
        assertEquals(expectedContent, parameter.toString());
    }
    
    @Test // tests two-value parameter
    public void canParseFormatType()
    {
        FormatType parameter = FormatType.parse("application/msword");
        String expectedContent = "FMTTYPE=application/msword";
        assertEquals(expectedContent, parameter.toString());
        assertEquals("application", parameter.getTypeName());
        assertEquals("msword", parameter.getSubtypeName());
    }
    
    @Test // tests two-value parameter
    public void canChangeFormatType()
    {
        FormatType parameter = FormatType.parse("application/msword");
        parameter.setSubtypeName("newapp");
        String expectedContent = "FMTTYPE=application/newapp";
        assertEquals(expectedContent, parameter.toString());
        assertEquals("application", parameter.getTypeName());
        assertEquals("newapp", parameter.getSubtypeName());
    }
}
