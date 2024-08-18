import { useMeta } from 'quasar'
import { siteName, url, locale } from '../settings'

interface UsePageMetaOptions {
  title: string
  description: string
  pageUrl?: string // 允许覆盖默认的 URL
  type?: string // 允许设置不同的 og:type，默认 'website'
}

export function usePageMeta({ title, description, pageUrl, type = 'website' }: UsePageMetaOptions) {
  useMeta({
    title: `${siteName}|${title}`,
    meta: {
      'og:locale': {
        property: 'og:locale',
        content: locale
      },
      'og:site_name': {
        property: 'og:site_name',
        content: siteName
      },
      'og:title': {
        property: 'og:title',
        content: title
      },
      'og:type': {
        property: 'og:type',
        content: type
      },
      'og:url': {
        property: 'og:url',
        content: pageUrl || url
      },
      'og:description': {
        property: 'og:description',
        content: description
      }
    }
  })
}

export const baseUrl: string = url
