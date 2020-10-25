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
package jfxtras.icalendarfx.properties.component.timezone;

import java.time.ZoneOffset;

import jfxtras.icalendarfx.components.StandardTime;

/**
 * TZOFFSETFROM
 * Time Zone Offset From
 * RFC 5545, 3.8.3.3, page 104
 * 
 * This property specifies the offset that is in use prior to this time zone observance.
 * 
 * EXAMPLES:
 * TZOFFSETFROM:-0500
 * TZOFFSETFROM:+1345
 * 
 * @author David Bal
 * @see DaylightSavingsTime
 * @see StandardTime
 */
public class TimeZoneOffsetFrom extends PropertyBaseZoneOffset<TimeZoneOffsetFrom>
{    
    public TimeZoneOffsetFrom(TimeZoneOffsetFrom source)
    {
        super(source);
    }
    
    public TimeZoneOffsetFrom(ZoneOffset value)
    {
        super(value);
    }
    
    public TimeZoneOffsetFrom()
    {
        super();
    }

    public static TimeZoneOffsetFrom parse(String content)
    {
    	return TimeZoneOffsetFrom.parse(new TimeZoneOffsetFrom(), content);
    }
}
